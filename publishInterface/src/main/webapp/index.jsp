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
				<a class="navbar-brand" href="/">Service publication</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><s:a namespace="/" action="/">Publish Service</s:a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container ">

		<div class="panel panel-default">
			<div class="panel-heading">Add new service</div>

			<div class="panel-body">
				<s:if test="%{message != null}">
					<div class="alert alert-info alert-dismissable">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<s:property escape="false" value="message" />
						.
					</div>
				</s:if>


				<form class="form-horizontal" method="post" action="addService">
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['category']">Service
							Service Category:</label>
						<div class="col-sm-9">
							<SELECT required="required" multiple size="3"
								class="form-control" id="hashMap['category']"
								name="hashMap['category']">
								<!--OPTION selected value="None Selected">--- Select Group ---</OPTION-->
								<OPTION selected value="Business and Commerce">Business
									and Commerce</OPTION>
								<OPTION value="Communications/Information">Communications/Information</OPTION>
								<OPTION value="Data Lookup">Data Lookup</OPTION>
								<OPTION value="Graphics and Multimedia">Graphics and
									Multimedia</OPTION>
								<OPTION value="Education">Education</OPTION>
								<OPTION value="Data Manipulation/Unit Conversion">Data
									Manipulation/Unit Conversion</OPTION>
								<OPTION value="Entertainment">Entertainment</OPTION>
							</SELECT>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['name']"
							required="required" value="hashMap['name']">Service Name
							: <span style="color: red">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="hashMap['name']"
								name="hashMap['name']" placeholder="service name"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['wsdl']"
							required="required">Service WSDL : <span
							style="color: red">*</span></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="hashMap['wsdl']"
								name="hashMap['wsdl']" placeholder="service wsdl"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['homeUrl']">Home
							Url:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="hashMap['homeUrl']"
								name="hashMap['homeUrl']" placeholder="home Url" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['owl']">Owl
							Url:</label>
						<div class="col-sm-9">
							<input required="required" type="text" class="form-control"
								id="hashMap['owl']" name="hashMap['owl']" placeholder="owl url" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['cost']">Service
							Cost $:</label>
						<div class="col-sm-9">
							<input type="number" step="0.1" class="form-control"
								id="hashMap['cost']" name="hashMap['cost']" placeholder="cost"
								value="0.0" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['description']">Service
							Description:</label>
						<div class="col-sm-9">
							<textarea class="form-control" id="hashMap['description']"
								name="hashMap['description']" placeholder="description"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="hashMap['properties']">Service
							Properties : <span style="color: red">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="form-control"
								id="hashMap['properties']" name="hashMap['properties']"
								placeholder="Multiple properties should be separated by ';'"
								required="required" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" for="pn"> </label>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-primary" value="Add">
						</div>
					</div>
				</form>

			</div>

		</div>
	</div>

</body>
</html>