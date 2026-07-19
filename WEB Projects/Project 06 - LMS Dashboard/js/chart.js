var options = {
    series: [
        {
            name: "Exams",
            data: [66, 40, 75, 55, 25]
        },
        {
            name: "Study",
            data: [35, 20, 63, 32, 18]
        }
    ],

    chart: {
        type: "bar",
        height: 350,
        stacked: false,
        toolbar: {
            show: false
        }
    },

    plotOptions: {
        bar: {
            horizontal: false,
            columnWidth: "45%",
            borderRadius: 12,
            borderRadiusApplication: "end"
        }
    },

    colors: [
        "#F8EFE2",
        "#FF9053"
    ],

    dataLabels: {
        enabled: false
    },

    stroke: {
        show: false
    },

    xaxis: {
        categories: ["Jan", "Feb", "Mar", "Apr", "May"]
    },

    yaxis: {
        max: 80,
        tickAmount: 4,
        labels: {
            formatter: function (val) {
                return val + " Hr";
            }
        }
    },

    grid: {
        borderColor: "#E9E9E9"
    },

    legend: {
        position: "top"
    }
};

var chart = new ApexCharts(document.querySelector("#chart"), options);
chart.render();