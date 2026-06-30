const ctx = document.getElementById("studyChart");

new Chart(ctx, {
    type: "bar",
    data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May"],

        datasets: [
            {
                label: "Exams",
                data: [66, 40, 75, 55, 25],
                backgroundColor: "#F8EFE2",
                borderRadius: 10,
                categoryPercentage: 0.6,
                barPercentage: 1,
                barThickness: 36,
                order: 1
            },
            {
                label: "Study",
                data: [35, 20, 63, 32, 18],
                backgroundColor: "#FF9053",
                borderRadius: 10,
                categoryPercentage: 0.6,
                barPercentage: .7,
                barThickness: 36,
                order: 2
            }
        ]
    },

    options: {
        responsive: true,

        scales: {
            y: {
                max: 80,
                beginAtZero: true,
                ticks: {
                    stepSize: 20,
                    callback: function (value) {
                        return value + " Hr";
                    }
                },

                grid: {
                    color: "#E9E9E9",
                    lineWidth: 1,
                    tickBorderDash: [3, 3],
                    tickLength: 0
                },

                border: {
                    display: false          // (v4) Y-axis шугам нуух
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