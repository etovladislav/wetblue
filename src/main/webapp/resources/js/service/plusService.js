adminModule.factory('plusService', function (addWatchToObjectForSaveToServer) {

    var getAllPlus = function () {
        var plus = [
            {
                id: 0,
                desc: '2 000 000 шкур овец',
                img: 'img/opyt/1.jpg'
            }
            ,
            {
                id: 1,
                desc: '1 800 000 шкур коз',
                img: 'img/opyt/2.jpg'
            },

            {
                id: 2,
                desc: 'Ни одного возврата',
                img: 'img/opyt/3.jpg'
            },

            {
                id: 3,
                desc: 'Возможность ручного выбора шкур клиентом',
                img: 'img/opyt/4.jpg'
            }

        ];

        angular.forEach(plus, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return plus;
    };

    var getNewPlus = function () {
        console.log("Ображение к серверу для создания нового плюса и ставю на него слушателя");
        var plus = {
            id: 1001,
            desc: 'Имя',
            img: 'img/opyt/1.jpg'
        };

        addWatchToObjectForSaveToServer.add(plus, save);
        return plus;
    };

    var save = function (plus) {
        console.log("сохраняем плюс");
    };

    this.getAllPlus = getAllPlus;
    this.getNewPlus = getNewPlus;
    this.save = save;

    return this;
});