adminModule.factory('documentService', function ($http) {

    this.getAllDocument = function () {
        return $http.get('/getAllDocument/');
    };

    this.save = function (document) {
        $http.post('/api/saveDocument/', document);
    };

    this.getNewDocument = function () {
        return $http.get('/api/getCleanDocument/');
    };

    this.delete = function (document) {
        $http.post('/api/deleteDocument/', document);
    };
    
    return this;
});