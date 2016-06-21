adminModule.factory('productionService', function (addWatchToObjectForSaveToServer) {

    var save = function (production) {
        console.log("Сохраняю информацию о производстве")
    };


    var getAllProduction = function () {

        var production = [
            {
                id: 0,
                name: 'Производственный цех',
                img: 'img/p1.jpg'
            },
            {
                id: 1,
                name: 'Производственный цех',
                img: 'img/p2.jpg'
            }, {
                id: 2,
                name: 'Производственный цех',
                img: 'img/p3.jpg'
            }];

        addWatchToObjectForSaveToServer.add(production, save);

        return production;
    };

    var getNewProduction = function () {
        console.log("Ображение к серверу для создания новой одукции");
        var production = {
            id: 0,
            name: 'Производственный цех',
            img: 'img/p1.jpg'
        };

        addWatchToObjectForSaveToServer.add(production, save);
        return production;
    };

    this.getNewProduction = getNewProduction;
    this.save = save;
    this.getAllProduction = getAllProduction;

    return this;
});