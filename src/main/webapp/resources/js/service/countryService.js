adminModule.factory('countryService', function (addWatchToObjectForSaveToServer) {

    var getAllCountry = function () {
        var countries = [
            {
                id: 0,
                name: 'Индия',
                img: 'img/flags/1.png'
            },
            {
                id: 1,
                name: 'Туркция',
                img: 'img/flags/2.png'
            },
            {
                id: 2,
                name: 'Италия',
                img: 'img/flags/3.png'
            },
            {
                id: 3,
                name: 'Китай',
                img: 'img/flags/4.png'
            },
            {
                id: 4,
                name: 'Пакистан',
                img: 'img/flags/5.png'
            }
        ];

        angular.forEach(countries, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return countries;
    };

    var save = function (country) {
        console.log("сохраняем страну");
    };


    var getNewCountry = function (id) {
        console.log("Ображение к серверу для создания нового товара и ставлю на него слушателя");
        var country =
        {
            id: 4,
            name: 'Пакистан',
            img: 'img/flags/5.png',
        };

        addWatchToObjectForSaveToServer.add(country, save);

        return country;
    };

    this.getAllCountry = getAllCountry;
    this.save = save;
    this.getNewCountry = getNewCountry;

    return this;
});