const ctx = document.getElementById("myChart");

new Chart(ctx, {
    type: "bar",

    data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May"],

        datasets: [
            {
                label: "Exams",
                data: [66, 40, 75, 55, 25],
                backgroundColor: "#F8EFE2",
                borderRadius: 12,
                barThickness: 36,
                order: 1
            },
            {
                label: "Study",
                data: [35, 20, 63, 32, 18],
                backgroundColor: "#FF9053",
                borderRadius: 12,
                barThickness: 20,
                order: 2
            }
        ]
    },

    options: {
        responsive: true,

        plugins: {
            legend: {
                display: false
            },

            title: {
                display: true,
                text: "World Wine Production 2018"
            }
        },

        scales: {
            y: {
                beginAtZero: true,
                max: 80,

                ticks: {
                    stepSize: 20,
                    callback(value) {
                        return value + " Hr";
                    }
                },

                grid: {
                    color: "#E9E9E9",
                    borderDash: [8, 8]
                },

                border: {
                    display: false
                }
            },

            x: {
                grid: {
                    display: false
                },

                border: {
                    display: false
                }
            }
        }
    }
});