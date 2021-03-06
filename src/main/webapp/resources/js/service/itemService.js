adminModule.factory('itemService', function ($http) {

    this.save = function (item) {
        $http.post('/api/saveItem', item);
    };


    this.getNewItem = function (id) {
        return $http.get('/api/getCleanItem/' + id);
    };


    this.delete = function (item) {
        $http.post('/api/deleteItem', item);
    };

    return this;
});