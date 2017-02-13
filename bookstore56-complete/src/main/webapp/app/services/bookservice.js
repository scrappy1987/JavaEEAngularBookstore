(function() {

    var BookService =  function() {
        var books = [{
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

        this.getBooks = function()
        {
            return books;
        };
    };



    angular.module('bookStore').service('bookService', [BookService]);
}());