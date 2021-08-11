'use strict';

// Controller Part
app.controller("EmployeeListarController", function($scope, $http, $window) {
 
 
    $scope.employees = [];
    $scope.employeeForm = {
        id: "",
        nombre: "",
        apellido: "",
		cargo: "",
		jefe: "",
		salario: "",
		fecha: ""
    };
 
    // Now load the data from server
    _refreshEmployeeData();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitEmployee = function() {
 
        var method = "";
        var url = "";
          method = "POST";
          url = '/employee';
        /*if ($scope.employeeForm.id == "") {
            method = "POST";
            url = '/employee';
        } else {
            method = "PUT";
            url = '/employee';
        }*/
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employeeForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.clearEmployee = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employee/' + employee.id
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editEmployee = function(employee) {
        $scope.employeeForm.id = employee.id;
        $scope.employeeForm.nombre = employee.nombre;
        $scope.employeeForm.apellido = employee.apellido;
		$scope.employeeForm.cargo = employee.cargo;
		$scope.employeeForm.jefe = employee.jefe;
		$scope.employeeForm.salario = employee.salario;
		$scope.employeeForm.fecha = employee.fecha;
		$scope.$parent.mivariable = employee.fecha;
		$window.location.href = '/'
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/employees'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.employeeForm.id = "";
        $scope.employeeForm.nombre = "";
        $scope.employeeForm.apellido = "",
		$scope.employeeForm.cargo = "",
		$scope.employeeForm.jefe = "",
		$scope.employeeForm.salario = "",
		$scope.employeeForm.fecha = ""
    };
});