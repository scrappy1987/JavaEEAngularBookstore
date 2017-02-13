"use strict";

(function () {

    angular.module("bookStore").service("bookDal", ["dal", BookDal]);

    function BookDal (dal) {

        this.getBooks = function () {
            return dal.http.GET("rest/bookstore/json");
        };

        this.saveBook = function (bookToSave) {
            return dal.http.POST("rest/bookstore/json", bookToSave);
        };

        this.updateBook = function (bookToUpdate) {
            return dal.http.PUT("rest/bookstore/json/", bookToUpdate);
        };

        this.deleteBook = function (bookToDelete) {
            return dal.http.DELETE("/rest/bookstore/json/", bookToDelete);
        };

    }
}());
