<html>
<head>
    <title>Application Response Page</title>
</head>
<body>
<h2>Your details</h2>
Name: ${applicantResponse.name}<br/>

Email: ${applicantResponse.email}<br/>

<p align="center">${applicantResponse.confirmation}</p><br/>

<p align="center"><img src="data:image/jpg;base64,${applicantResponse.qrImage}"></p><br/>
</body>
</html>