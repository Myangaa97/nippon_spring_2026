const labels = ['Jan', 'Feb', 'Mar', 'Apr', 'May'];

// Оруулах өгөгдөл
const data = {
    labels: labels,
    datasets: [
        {
            label: 'Study',
            data: [30, 21, 60, 32, 17],
            backgroundColor: '#FF9053',
            barThickness: 46,
            borderRadius: {
                bottomLeft: 10,
                bottomRight: 10
            }
        },
        {
            label: 'Exam',
            data: [35, 20, 15, 23, 10],
            backgroundColor: '#F8EFE2',
            barThickness: 46,
            borderRadius: {
                topLeft: 10,
                topRight: 10,
                bottomLeft: 10,
                bottomRight: 10
            }
        },
    ]
};

// Графикын тохиргоо
const config = {
    type: 'bar',
    data: data,
    options: {
        responsive: true,
        plugins: {
            legend: {
                display: false
            }
        },
        scales: {
            x: {
                stacked: true,
                grid: {
                    display: false,
                    drawBorder: false,
                },
                border: {
                    display: false,
                }
            },
            y: {
                beginAtZero: true,
                stacked: true,
                ticks: {
                    stepSize: 20
                },
                grid: {
                    color: '#E9E9E9',
                    lineWidth: 2
                },
                border: {
                    display: false,
                    dash: [10, 10]
                }
            }
        }
    },
};

// Графикыг зурах
const myChart = new Chart(
    document.getElementById('scoreChart'), // Canvas ID-г scoreChart болгов
    config
);
