(function() {

    var BookService =  function(bookDal) {
        this.getBooks = function()
        {
            bookDal.getBooks();
        };
    };



    angular.module('bookStore').service('bookService', ['bookDal', BookService]);
}());