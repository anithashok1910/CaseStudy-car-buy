var app = angular.module('myApp', []);
app.controller('MainCtrl', function ($scope, $http) {
    $scope.c = {};
    $scope.showWhat = function () {
        $scope.beforeOrder = true;
        $scope.afterOrder = false;
    }

    $scope.getCarData = function () {
        $http({
            method: "GET",
            url: "/list.do"
        }).then(function mySuccess(response) {
            $scope.cars = response.data;
        }, function myError(response) {
            alert("Unable to process request! Please try again later");
            $scope.cars = response.statusText;
        });
    }

    $scope.demo = function (c) {
        $scope.showWhat();
        $scope.id = c.id;
        $scope.make = c.make;
        $scope.imageURL = c.imageURL;
        $scope.model = c.model;
        $scope.year = c.year;
        $scope.price = c.price;
        $scope.description = c.description;
    }


    $scope.sendData = function (car, customer) {
        var order_ID = 0;
        var order = new Order(order_ID,car,customer);
        console.log(order)
        var params = {
            "carId": car.id,
            "model": car.model,
            "make": car.make,
            "price": car.price,
            "year": car.year,
            "name":customer.name,
            "address":customer.address,
            "email":customer.email,
            "mob_no":customer.mob_no
        }
        $http({
            url: "/placeOrder.do",
            method: 'POST',
            params: params,
            paramSerializer: '$httpParamSerializerJQLike',
            contentType:"application/json",
            dataType:"JSON"

        }).then(function mySucces(response) {
            $scope.order = response.data;
            $scope.beforeOrder = false;
            $scope.afterOrder= true;
        }, function myError(response) {
            alert("Unable to process request! Please try later");
            console.log(response.data);

        });
    }

    $scope.sendValues=function() {
        var customerId = 0;
        var name = $scope.name;
        var address = $scope.address;
        var email = $scope.email;
        var contactNo = $scope.phone;
        var id = $scope.id;
        var make = $scope.make;
        var model = $scope.model;
        var price = $scope.price;
        var year = $scope.year;
        var car = new Car(id, make, model, price, year);
        var customer = new Customer(customerId, name, address, email, contactNo);
        $scope.sendData(car, customer);
        return false;
    }

     function Car(id, make, model, price, year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    function Order(orderID,car,customer) {
        this.orderID = orderID;
        this.car = car;
        this.customer = customer;
    }

    function Customer(Id, name, address, email, contactNo) {
        this.customerId = Id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = contactNo;
    }
});




