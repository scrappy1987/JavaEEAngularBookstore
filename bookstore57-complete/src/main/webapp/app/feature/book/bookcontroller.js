(function() {

    var BookController =  function(bookService)
    {
        var vm = this;

        vm.books = [];

        vm.reverse =false;

        vm.doSort = function()
        {
            vm.sortby = 'Title';
            vm.reverse= !vm.reverse
        };

        function init() {
            vm.books = bookService.getBooks();
        }
        init();
    };
    angular.module('bookStore').controller('BookController', ['bookService', BookController]);
}());