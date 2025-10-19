/*
 * eframe-api - api接口网关模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.frame.api.sys;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;

import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.script.json.StringMap;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.comm.utils.EnumUtil;
import net.linlan.frame.view.sys.service.FrameDictionaryService;
import net.linlan.sys.core.constant.AccountTypeEnum;
import net.linlan.sys.core.dto.CoreAccountDto;
import net.linlan.sys.core.entity.CoreAccount;
import net.linlan.sys.core.param.CoreAccountParam;
import net.linlan.sys.core.service.CoreAccountService;
import net.linlan.utils.crypt.RSAUtil;
import net.linlan.utils.crypt.ShaUtils;

/**
 *
 * 平台账号信息读写控制类
 * @author Linlan
 * CreateTime 2024-11-19 14:58:36
 *
 */
@RestController
@RequestMapping("/api/system")
public class CoreAccountController extends BaseController {
    @Resource
    private CoreAccountService     memberAccountService;
    @Resource
    private FrameDictionaryService frameDictionaryService;

    /** Get CoreAccount list. 获取平台账号信息列表或分页, 返回CoreAccount对象.
     * @param param 参数查询对象
     * @return 获取平台账号信息列表或分页, 返回CoreAccount对象.
     */
    @PreAuthorize("@ss.hasPerms('system:account:list')")
    @PlatLog(value = "查询平台账号信息分页")
    @GetMapping("/plat/account/list")
    public ResponseResult<List<CoreAccountDto>> list(CoreAccountParam param) {
        Page<CoreAccountDto> result = memberAccountService.getPageDto(param);
        Map<String, String> typeMap = frameDictionaryService
            .getByTypeCode("PLATACCOUNT_INPUT_MODE");
        LinkedHashMap<String, String> TypeEnumMap = EnumUtil.enumToMap(AccountTypeEnum.class);
        for (CoreAccountDto memberAccountDto : result) {
            memberAccountDto.setInoutModeName(typeMap.get(memberAccountDto.getInoutMode() + ""));
            memberAccountDto.setTypeName(TypeEnumMap.get(memberAccountDto.getType() + ""));
        }

        if (result == null) {
            return empty();
        }
        return successPage(result);
    }

    /**
     * 平台账户生成密钥对
     * @param clientId  客户ID
     * @return  密钥信息
     */
    @PlatLog(value = "生成密钥 id: 平台账户主键  clientId :平台账户应用Id")
    @GetMapping("/plat/account/getClientSecret")
    public ResponseResult<List<CoreAccountDto>> getClientSecret(String clientId) {
        String clientSecret = ShaUtils.getSHA256(clientId);
        Map<String, String> result = new HashMap<>();
        if (ObjectUtils.isNotEmpty(clientSecret)) {
            result.put("clientSecret", clientSecret);
        }
        return success(result);
    }

    /**
     * 生成平台密钥对
     * @param id    账号ID
     * @return  密钥信息
     * @throws Exception    异常
     */
    @PlatLog(value = "生成平台密钥对")
    @GetMapping("/plat/account/getKeyParity")
    public ResponseResult<List<CoreAccountDto>> getKeyParity(String id) throws Exception {
        Map<String, String> result = new HashMap<>();
        KeyPair keyPair = RSAUtil.getKeyPair();
        String aesIvKey = new String(
            org.apache.commons.codec.binary.Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String aesKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        result.put("aesKey", aesKey);
        result.put("aesIvKey", aesIvKey);
        return success(result);
    }

    /**
     * Get CoreAccount by id. 主键获取平台账号信息详细信息.
     * @param id 信息ID|1
     * @return {@link CoreAccount}:空null,error;分页page,success
     */
    @PreAuthorize("@ss.hasPerms('system:account:detail')")
    @PlatLog(value = "主键获取平台账号信息详细信息", category = 1)
    @GetMapping(value = "/account/{id}")
    public ResponseResult<CoreAccount> info(@PathVariable("id") String id) {
        return success(memberAccountService.findById(id));
    }

    /** CoreAccount Operation. 新增平台账号信息数据操作逻辑，根据操作类型，执行新增操作.
     * @param input 对象信息，输入CoreAccount对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:account:save')")
    @PlatLog(value = "新增平台账号信息", category = 10)
    @PostMapping("/account/save")
    @LimitScope(name = "coreAccountSave", key = "coreAccountSave")
    public ResponseResult<String> save(@RequestBody CoreAccount input) {
        if (StringUtils.isNotBlank(input.getId()) && !checkCodeUnique(input)) {
            return error("新增平台账号'" + input.getId() + "'失败，平台账号ID已存在");
        }
        memberAccountService.save(input);
        return success();
    }

    public boolean checkCodeUnique(CoreAccount input) {
        int i = memberAccountService.getCount(new StringMap().put("existKey", input.getId()).map());
        if (i > 0) {
            return false;
        }
        return true;
    }

    /** CoreAccount Operation. 修改平台账号信息数据操作逻辑，根据操作类型，执行修改操作.
     * @param input 对象信息，输入CoreAccount对象
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:account:update')")
    @PlatLog(value = "修改平台账号信息", category = 20)
    @PostMapping("/account/update")
    @LimitScope(name = "coreAccountUpdate", key = "coreAccountUpdate")
    public ResponseResult<String> update(@RequestBody CoreAccount input) {
        memberAccountService.update(input);
        return success("SUCCESS");
    }

    /** CoreAccount Operation. 删除平台账号信息数据操作逻辑，根据操作类型，执行删除操作.
     * @param ids 信息ID:null;1;1,2,3|1
     * @return {@link String}:操作成功0;操作失败1
     */
    @PreAuthorize("@ss.hasPerms('system:account:delete')")
    @PlatLog(value = "删除平台账号信息", category = 40)
    @PostMapping("/account/delete/{ids}")
    @LimitScope(name = "coreAccountDelete", key = "coreAccountDelete")
    public ResponseResult<String> delete(@PathVariable String[] ids) {
        memberAccountService.deleteByIds(ids);
        return success("SUCCESS");
    }

}
