<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Publication des services</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<s:a class="navbar-brand" namespace="/" action="/">Service publication</s:a>
			</div>
			<ul class="nav navbar-nav">
				<li >
					<s:a namespace="/" action="/" >Publish Service</s:a>
				</li>
				<li class="active"><s:a namespace="/" action="listServices" >My Services</s:a></li>
			</ul>
		</div>
	</nav>

	<div class="container ">

		<div class="panel panel-default">
			<div class="panel-heading">Add new service</div>

			<div class="panel-body">

				<s:form class="form-horizontal" namespace="/" action="addService">
					<div class="form-group">
						<label class="control-label col-sm-3" for="serviceName">Service
							Name:</label>
						<div class="col-sm-9">
							<input class="form-control" id="serviceName" name="serviceName"
								placeholder="service name" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="pn"> </label>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-primary" value="Add">
						</div>
					</div>
				</s:form>

			</div>

		</div>
	</div>

</body>
</html>