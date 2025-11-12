<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>第三方社交平台登录</title>
</head>
<body>
登录中...
<script>
window.onload = function () {
    const data = {
        platformType: "${platformType}",
        code: "${code}",
        state: "${state}"
    }

    window.opener.postMessage(data, "*");
    window.close();
}
</script>
</body>
</html>