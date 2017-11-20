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
				<a class="navbar-brand" href="/">Search service</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><s:a namespace="/" action="/">search Service</s:a>
				</li>
				<%-- 				<li><s:a namespace="/" action="listServices">My Services</s:a></li> --%>
			</ul>
		</div>
	</nav>

	<div class="container ">

		<div class="panel panel-default">
			<div class="panel-heading">Search for a service</div>

			<div class="panel-body">
				<s:if test="%{message != null}">
					<div class="alert alert-info alert-dismissable">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<s:property escape="false" value="message" />
					</div>
				</s:if>


				<form class="form-horizontal" method="post" action="searchService">
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
							<input type="submit" class="btn btn-primary" value="Search">
						</div>
					</div>
				</form>

			</div>

		</div>

		<div class="panel panel-default">
			<div class="panel-heading">Result</div>

			<div class="panel-body">
				<table class="table table-bordered">
					<tr>
						<td>Rank</td>
						<td>Name</td>
						<td>Description</td>
						<td>Rating</td>
						<td>Action</td>
					</tr>
					<s:iterator value="result">
						<tr>
							<s:iterator value="value" status="el">

								<td><s:if test="#el.isLast()== true">
										<a href="#" data="<s:property />"></a>
									</s:if> 
									<s:elseif test="#el.index == value.size()-2">
										<s:property /> <img alt=""
											src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAQAAAAngNWGAAACAUlEQVQ4y3XSzUtUURiA8cePCZ0xZ+69M3Pec+6ZySJCK0TMwEUYGlJt+pQIJCENixoKItq0KgmjVkGL2gRSf0AZESW1UOjDEkIUTQustCmqVWaLElvMgHhRnt3hxzm8vIcFlvaYyMV4VzGHA+cE4fOI89P8iXpHloNTtHMs395zZtS+iV1bFg5RQpgIEcpKYl9Ni62Pzh1Vy8C3xEmiUOgOmVGrNPFXh268ZzLfBJ9ycII4KqRTpsFkJaNQ2AY7v+ZkujG1PlVuSdAMdzZnzrRdVwN6Sn8zH/17ukShENJX/GEzbb6bz3rQe9TcRntl0YSzUHFBdsoGCQsqn6AxYZOyjXrOGdmxjk7chH1hHiySxZII0iuvXacJOoki5f7L9JDv5AaKE8NBoTAh2ycj4jo0QRuFhFldqvrskE0p4lTTzHYEHU73ynDUDVNMPdzmOBlOUV0sMxVnFXFq2EUTgl7r/1Wb9pHhBN2LK2wpdD/YPUkEj2ju6ZCZ8nY/Ce56v+/+8CuTKCRhanLD6GfupadBeGCbl9XokD0tWf1b3ze1gr4cezgQhAc7vGHb4o+nJk2rbDQ99oe+K13OaH9B8MbusgXJmvOq1MPBJVGpery5yHy/LIUFrTf11YpEGksVddSxhTq2VlXfGqwNwOnoGOO8Y4wvzOb7xSz/ilb44Sv1H/YY+1hZ6JbXAAAAAElFTkSuQmCC">
										
									</s:elseif> <s:else>
										<s:property />
									</s:else></td>

							</s:iterator>
						</tr>
					</s:iterator>
				</table>

			</div>

		</div>

	</div>

</body>
</html>