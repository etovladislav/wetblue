adminModule.directive('ngPanel', function (userService, ngDialog) {
    return {
        restrict: 'AE',
        link: function ($scope, element, attrs) {
            userService.isAuth().success(function (data) {
                if (data) {
                    var parentDiv = $('<div id="function-menu"> </div>');
                    var childDivPreview = $('<div class="item">Включить режим просмотра</div>');
                    var childDivExit = $('<div class="item"><a href="/logout">Выход</a></div>');
                    var childDivInfo = $('<div class="item">Информация о сисетеме</div>');

                    var on = true;
                    childDivPreview.on("click", function () {
                        if (on) {
                            $(this).html('Выключить режим просмотра');
                            $(".ng-add-button").hide();
                            $(".ng-replace-edit-icon").hide();
                            on = false;
                        } else {
                            $(this).html('Включить режим просмотра');
                            $(".ng-add-button").show();
                            $(".ng-replace-edit-icon").show();
                            on = true;
                        }
                    });

                    parentDiv.append(childDivPreview);
                    parentDiv.append(childDivInfo);
                    parentDiv.append(childDivExit);
                    $('body').append(parentDiv);
                }
            });
        }
    }
});