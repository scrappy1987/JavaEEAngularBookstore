(function() {

    var BookService =  function(bookDal) {
        
    	this.getBooks = function()
        {
            return bookDal.getBooks();
        };
    };

    angular.module('bookStore').service('bookService', ['bookDal', BookService]);
}());