adminModule.factory('productService', function ($http) {

    this.getAllProduct = function () {
        return $http.get('/api/getAllCategory');
    };

    this.getNewProduct = function () {
        return $http.post('/api/getCleanCategory');
    };

    this.save = function (product) {
        $http.post('/api/saveCategory', product);
    };

    return this;
});