adminModule.factory('productService', function (itemService, addWatchToObjectForSaveToServer) {

    var getAllProduct = function () {
        var products = [];
        $http.get('/api/getAllCategory').success(function (data) {
            console.log(data);
            products = data;
        });

        angular.forEach(products, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return products;
    };

    var getNewProduct = function () {
        console.log("Ображение к серверу для создания новой категории и ставю на него слушателя");
        var product = {
            id: 1001,
            name: 'Имя',
            items: []
        };

        addWatchToObjectForSaveToServer.add(product, save);
        return product;
    };

    var save = function (product) {
        console.log("сохраняем категорию");
    };

    this.getAllProduct = getAllProduct;
    this.getNewProduct = getNewProduct;
    this.save = save;

    return this;
});