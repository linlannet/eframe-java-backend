/*
 * module-quartz - quartz定时任务模块
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
package net.linlan.sys.job.constant;

/**
 * 任务调度通用常量
 * 
 * @author Linlan
 */
public class ScheduleConstants {
    public static final String TASK_CLASS_NAME          = "TASK_CLASS_NAME";

    /** 执行目标key */
    public static final String TASK_PROPERTIES          = "TASK_PROPERTIES";

    /** 默认 */
    public static final String MISFIRE_DEFAULT          = "0";

    /** 立即触发执行 */
    public static final String MISFIRE_IGNORE_MISFIRES  = "1";

    /** 触发一次执行 */
    public static final String MISFIRE_FIRE_AND_PROCEED = "2";

    /** 不触发立即执行 */
    public static final String MISFIRE_DO_NOTHING       = "3";

    public enum Status {
                        /**
                         * 正常
                         */
                        NORMAL("0"),
                        /**
                         * 暂停
                         */
                        PAUSE("1");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
