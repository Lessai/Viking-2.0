<#import "parts/common.ftlh" as c>
<#import "parts/autocompleteFunction.ftlh" as a>

<@c.page>
<!-- example charts - dark -->
<div class="block">
    <div class="container">
        <h5 class="mb-4">Прогноз распределения средств и % регистрации на тренинги с помощью метода Монте Карло</h5>
        <p style="text-indent: 20px;">Метод Монте-Карло представляет собой универсальный метод, применяемый для решения задач самых различных классов: вероятностных и детерминированных, задач с дискретными и непрерывными величинами, задач моделирования и оптимизации и т.д. </p>
        <p style="text-indent: 20px;">Метод Монте-Карло основан на применении <i>случайных равномерно распределенных чисел</i> (СРРЧ). Расчет (розыгрыш) СРРЧ выполняется по специальным алгоритмам, позволяющим получать бесконечную последовательность таких чисел. Эти алгоритмы разработаны таким образом, что СРРЧ всегда принимают значения из диапазона от нуля до единицы.</p>
        <p style="text-indent: 20px;">Данная модель имитирует регистрацию на тренинг. Было произведена имитация в <b>10 000</b> итераций. Данные о средних ценах на тренинг и вероятность регистрации на различные группы тренингов расчитаны на основе бвзы даннных.</p>
        <div class="container mb-5">
            <div class="row">
                <div class="col">
                    <div class="span4">
                        <h5>Показатели после выполнения имитации</h5>
                        <div id="columnchart" class="chart"></div>
                    </div>
                </div>
                <div class="col">
                    <div class="span4">
                        <h5>Процентное соотношение регистраций</h5>
                        <div id="piechart" class="chart"></div>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-sm table-bordered table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">TrainingSkill</th>
                <th scope="col">lRange</th>
                <th scope="col">uRange</th>
                <th scope="col">RegistrationQty</th>
                <th scope="col">TotalCost</th>
                <th scope="col">AvgPrice</th>
                <th scope="col">AvgCost</th>
            </tr>
            </thead>
            <tbody>
            <#list trainingForecasts as forecast>
                <tr>
                    <td>${forecast.trainingSkill!"null or missing"}</td>
                    <td>${forecast.lRange!"null or missing"}</td>
                    <td>${forecast.uRange!"null or missing"}</td>
                    <td>${forecast.registrationQty!"null or missing"}</td>
                    <td>${forecast.totalCost!"null or missing"}</td>
                    <td>${forecast.avgPrice!"null or missing"}</td>
                    <td>${forecast.totalCost/10000!0}</td>
                </tr>
            <#else>
                No forecast
            </#list>
            </tbody>
            <thead class="thead-dark">
            <tr>
                <th scope="col">Total</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col">10000</th>
                <th scope="col">${totalCost}</th>
                <th scope="col">--</th>
                <th scope="col">${avgCost}</th>
            </tr>
            </thead>
        </table>

    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    google.load("visualization", "1", {packages:["geochart", "bar", "corechart"]});

    google.setOnLoadCallback(drawChart);

    function drawChart() {
        var data2 = google.visualization.arrayToDataTable([
            ['Skill', 'TotalCost K', 'AvgPrice', 'AvgCost'],
            <#list trainingForecasts as forecast>
            ['${forecast.trainingSkill}', ${forecast.totalCostK?string("0")},${forecast.avgPrice?string("0")}, ${forecast.avgCost?string("0")}],
            </#list>
        ]);
        var piedata = google.visualization.arrayToDataTable([
            ['Name', 'Count'],
            <#list trainingForecasts as forecast>
            ['${forecast.trainingSkill}', ${forecast.registrationQty?string("0")}],
            </#list>
        ]);

        var optionsdark = {
            hAxis: {
                titleTextStyle: {color: '#37474f'},
                gridlines: { count:0},
                textStyle: { color: '#37474f', fontName: 'Roboto', fontSize: '12', bold: true}
            },
            vAxis: {
                minValue: 0,
                gridlines: {color:'#37474f', count:4},
                baselineColor: 'transparent'
            },
            legend: {position: 'top', alignment: 'center', textStyle: {color:'#607d8b', fontName: 'Roboto', fontSize: '12'} },
            colors: ["#3f51b5","#2196f3","#00bcd4","#009688","#4caf50","#8bc34a","#cddc39","#03a9f4"],
            areaOpacity: 0.24,
            lineWidth: 1,
            backgroundColor: 'transparent',
            chartArea: {
                backgroundColor: "transparent",
                width: '100%',
                height: '80%'
            },
            height:250, // example height, to make the demo charts equal size
            width:500,
            pieSliceBorderColor: '#263238',
            pieSliceTextStyle:  {color:'#263238' },
            pieHole: 0.9,
            bar: {groupWidth: "40" },
            colorAxis: {colors: ["#3f51b5","#2196f3","#03a9f4","#00bcd4"] },
            backgroundColor: 'transparent',
            datalessRegionColor: '#37474f',
            displayMode: 'regions'
        };
// draw the demo charts
        var timeout = 200;
// dark demo charts
        setTimeout(function(){
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(piedata, optionsdark);
        }, timeout*4);
        setTimeout(function(){
            var chart2 = new google.visualization.ColumnChart(document.getElementById('columnchart'));
            chart2.draw(data2, optionsdark);
        }, timeout*5);
    }


    $(window).resize(function(){
        drawChart();
    });
</script>
</@c.page>