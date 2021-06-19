<%--
  Created by IntelliJ IDEA.
  User: Shenshuxin
  Date: 2021/6/18
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.staticfile.org/angular.js/1.6.3/angular.min.js"></script>
  </head>
  <body>
  <div ng-app="myApp" ng-controller="myCon">
    <h1 style="color: red">  {{pg.showValue}}</h1><br>
    <input type="text">
    <button ng-click="fun1();">查询</button>
    <button ng-click="fun2();">插入</button>
    <button ng-click="rf();">Redis测试</button>
  </div>
  <script>
    var app = angular.module('myApp', []);
    app.controller('myCon',function ($scope,$http) {
        $scope.pg={};
        $scope.pg.showName=true;
        $scope.pg.data="";
        $scope.pg.showValue="这是第五次";

      $scope.$watch('pg.showValue',function () {

        window.setTimeout(function () {
                  $scope.pg.showValue="这是第五次";
                  $scope.$applyAsync();
                },
                3800);

      });
        $scope.fun1=function () {
          $scope.pg.data= document.getElementsByTagName("input")[0].value;
          $http.post("five/s.do",$scope.pg).then(function (response) {
            response=response.data;
            if (response.status == 'succ'){
              $scope.pg.showValue=response.data;
              $scope.$applyAsync();
            }else {
              alert("查询失败")
            }

          });
        }      ;
        $scope.fun2=function () {
          $scope.pg.data= document.getElementsByTagName("input")[0].value;
          $http.post("five/i.do",$scope.pg).then(function (response) {

            response=response.data;
            if (response.status == 'succ'){
              $scope.pg.showValue=response.data;
              $scope.$applyAsync();
            }else {
              alert("插入失败")
            }
          });
        }
        $scope.rf=function () {
          $scope.pg.data= document.getElementsByTagName("input")[0].value;
          $http.post("five/r.do",$scope.pg).then(function (response) {
              alert(response.data)
              alert(response.varr)
            // response=response.data;
            if (response.status == 200){
              $scope.pg.showValue=response.data.varr;
              $scope.$applyAsync();
            }else {
              alert("获取redis失败")
            }
          });
        }

    })
  </script>

  </body>
</html>
