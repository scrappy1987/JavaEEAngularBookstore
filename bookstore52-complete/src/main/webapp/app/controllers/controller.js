(function() {

    var BookController =  function($scope)
    {
        $scope.sortby = 'Title';
        $scope.reverse =false;

        $scope.books = [{
            'Author': 'James Herbert',
            'Title': 'Rats',
            'Genre': 'Horror',
            'Published': '1988'

        }, {
            'Author': 'J K Rowling',
            'Title': 'Harry Potter',
            'Genre': 'Fantasy',
            'Published': '1998'
        }, {
            'Author': 'Stephen King',
            'Title': 'Carrie',
            'Genre': 'Horror',
            'Published': '1984'
        }];

        $scope.doSort = function(propName)
        {
            $scope.sortBy= propName;
            $scope.reverse= !$scope.reverse
        };
    };
    angular.module('bookStore').controller('BookController', ['$scope', BookController]);
}());