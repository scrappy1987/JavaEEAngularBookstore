"use strict";

(function () {

    angular.module('bookStore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/book");

        $stateProvider.state("book", {
            url: "/book",
            templateUrl: "app/feature/book/books.html"
        }).state("dashboard", {
                url: "/dashboard",
                templateUrl: "app/feature/dashboard/dashboard.html"
        })
    });
}());