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
        <div class="col col-12 pt-1 pb-1 text-danger" th:text="'授权失败：' + ${errorMsg}">
        </div>
    </div>
</div>

</body>

<script>
    $(function(){
        $('.toast').toast('show')
    })
</script>
</html>
