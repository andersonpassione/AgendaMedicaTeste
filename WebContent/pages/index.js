/**
 * Aqui fica o JavaScript e os Controllers do Angular;
 * 
 */

app.controller("TesteController", [
	'$http',
	'$scope',
	function($http, $scope) {
		var controller = this;
		
		
		
		controller.testeDeEvento = function(){
			if (controller.inputTeste == undefined){
				alert("Preencher o input");
			} else{
				alert(controller.inputTeste);	
			}
		}
		
		
		$( document ).ready(function() {
		    console.log( "ready!" );
		});
		
	}]);