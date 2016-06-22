adminModule.factory('documentService', function ($http) {

    this.getAllDocument = function () {
        return $http.get('/api/getAllDocument/');
    };

    this.save = function (document) {
        $http.post('/api/saveDocument/', document);
    };

    this.getNewDocument = function () {
        return $http.get('/api/getCleanDocument/');
    };


    return this;
});