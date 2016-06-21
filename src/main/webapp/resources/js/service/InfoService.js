adminModule.factory('infoService', function (addWatchToObjectForSaveToServer) {

    var save = function (info) {
        console.log("Сохраняю информацию")
    };


    var getInfo = function () {

        var info = {
            id: 0,
            name: 'WETBLUE',
            desc: 'Завод по обработке и продаже шкур мелкого рогатого скота',
            phone: '810998903282007',
            mail: 'zakaz@wetblue.biz',
            adres: 'Узбекистан город Ташкент Серегельский район Южная промзона',
            group: 'ООО «TANNER TRADE»'
        };

        addWatchToObjectForSaveToServer.add(info, save);

        return info;
    };

    this.save = save;
    this.getInfo = getInfo;

    return this;
});