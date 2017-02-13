(function() {

    var BookController =  function(bookService)
    {
        var vm = this;
        
        vm.reverse =false;

        vm.doSort = function()
        {
            vm.sortby = 'Title';
            vm.reverse= !vm.reverse
        };

        function init() {
             bookService.getBooks().then(function (results) {
            	 console.log("In book controller about to return data to the client with results " + results);
            	 vm.books  = results;
             }, function (error) {
                 vm.error = true;
                 vm.errorMessage = error;
             });
        }
        
        init();
    };
    angular.module('bookStore').controller('BookController', ['bookService', BookController]);
}());