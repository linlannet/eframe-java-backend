<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>第三方社交平台登录</title>
</head>
<body>
<div class="container">
    <div class="row mt-3">
        <div class="col col-12">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col" style="width: 8%">编号</th>
                    <th scope="col" style="width: 27%">UUID</th>
                    <th scope="col" style="width: 15%">Avatar</th>
                    <th scope="col" style="width: 15%">username</th>
                    <th scope="col" style="width: 10%">来源</th>
                    <th scope="col" style="width: 15%">accessToken</th>
                    <th scope="col" style="width: 13%">rawUserInfo</th>
                    <th scope="col" colspan="2" style="width: 10%">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="user,userStat: ${users}">
                    <th scope="row" th:text="${userStat.index}">1</th>
                    <td th:text="${user.uuid}" style="word-break: break-all;"></td>
                    <td><img th:src="${user.avatar}" width="20" alt=""></td>
                    <td th:text="${user.username}"></td>
                    <td><img th:src="${'https://linlan.net/files/public/images/logo/' + #strings.toLowerCase(user.source) + '.png'}" th:title="${#strings.toLowerCase(user.source)}" width="20" alt=""></td>
                    <td><a href="javascript:;;" data-toggle="modal" data-target="#modal-show">查看详情</a><span th:text="${user.token.accessToken}" class="" style="display: none;"></span></td>
                    <td><a href="javascript:;;" data-toggle="modal" data-target="#modal-show">查看详情</a><span th:text="${user.rawUserInfo}" class="rawUserInfo" style="display: none;"></span></td>
                    <td><a href="javascript:;;" class="btn-refresh-token" th:data-uuid="${user.uuid}" th:data-source="${user.source}">refresh</a></td>
                    <td><a href="javascript:;;" class="btn-revoke-token" th:data-uuid="${user.uuid}" th:data-source="${user.source}">revoke</a></td>
                </tr>
                <tr style="text-align: center" th:if="${users == null || users.size() == 0}">
                    <td colspan="8" class="text-secondary">暂无数据</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

<script>
    $(function(){
        $('.toast').toast('show');

        $('#modal-show').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget);
            var rawUserInfo = button.parent().find('span').text();
            var modal = $(this);

            modal.find('.modal-body').html('').html(rawUserInfo);
        });

        $(".btn-refresh-token").click(function () {
            var uuid = $(this).data('uuid');
            var source = $(this).data('source');
            $.post("/login/social/refresh/" + source + "/" + uuid, {}, function (json) {
                alert(json.msg);
            })
        });

        $(".btn-revoke-token").click(function () {
            var uuid = $(this).data('uuid');
            var source = $(this).data('source');
            $.post("/login/social/revoke/" + source + "/" + uuid, {}, function (json) {
                alert(json.msg);
            })
        })
    })
</script>
</html>
