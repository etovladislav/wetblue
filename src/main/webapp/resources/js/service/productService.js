adminModule.factory('productService', function ($http) {

    this.getAllProduct = function () {
        return $http.get('/getAllCategory');
    };

    this.getNewProduct = function () {
        return $http.post('/api/getCleanCategory');
    };

    this.save = function (product) {
        $http.post('/api/saveCategory', product);
    };


    this.delete = function (product) {
        $http.post('/api/deleteCategory', product);
    };

    return this;
});