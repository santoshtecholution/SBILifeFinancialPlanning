<!DOCTYPE html>
<html lang="en" ng-app="SBIApp">
<head>
<title>SBI Life</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/gateway.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-sanitize.min.js"></script>
<script src="js/gateway.js"></script>

</head>
<body>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>SBI Life Financial Planning</h1>
		</div>
	</div>



	<div class="container">
		<div class="row">
		
		<div ng-controller="PeerDataControl as ctrl">
		    <div class="col-sm-6" ng-if="ctrl.noError">
			    <div class="panel panel-primary" >
			    	<div class="panel-heading">Peer Data Service</div>
					<div class="panel-body" >
						<p>
							<strong>Age:</strong> {{ctrl.peerdata.age}}
						</p>
						<p>
							<strong>Insurance: </strong>{{ctrl.peerdata.insurance | currency:'&#8377;'}}
						</p>
					</div>
				</div>
		    </div>
		</div>
				    
		<div ng-controller="InvestmentControl as ctrl">	    
		   <div class="col-sm-6" ng-if="ctrl.noError">
			    <div class="panel panel-primary" >
			    	<div class="panel-heading">Current Investment</div>
					<div class="panel-body" >
						<p ng-repeat="investment in ctrl.investments"><strong>{{investment.type}}: </strong>{{investment.amount | currency:'&#8377;'}}</p>
					</div>
				</div>
		    </div>
	    </div>
		    
		<div ng-controller="GoalControl as ctrl">	    
			<div class="col-sm-6" ng-if="ctrl.noError">
				<div class="panel panel-primary" >
					<div class="panel-heading">Goals</div>
					<div class="panel-body">
						<p ng-repeat="goal in ctrl.goals"><strong>{{goal.goal}}</strong></p>
					</div>
				</div>
			</div>
		</div>
			
  		<div ng-controller="DemographicControl as ctrl">	
			<div class="col-sm-6" ng-if="ctrl.noError">
				<div class="panel panel-primary" >
					<div class="panel-heading">User Demographic Service</div>
					<div class="panel-body">
						<p>
							<strong>Name:</strong> {{ctrl.demography.name}}
						</p>
						<p>
							<strong>Age: </strong>{{ctrl.demography.age}}
						</p>
						<p>
							<strong>Location: </strong>{{ctrl.demography.location}}
						</p>
					</div>
				</div>
			</div>
		</div>
			
  
  		</div>
	</div>


	<footer class="container-fluid text-center">
		<p>SBI Copyrights</p>
	</footer>

</body>
</html>
