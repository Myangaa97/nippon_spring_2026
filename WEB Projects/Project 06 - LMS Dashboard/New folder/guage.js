const ctx = document.getElementById("myChart");

new Chart(ctx, {
    type: "bar",
    data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May"],
        datasets: [
            // Саарал ар тал
            {
                data: [100, 100, 100, 100, 100],
                backgroundColor: "#E8E8E8",
                borderRadius: 20,
                barThickness: 30,
                grouped: false
            },
            // Progress
            {
                data: [70, 45, 90, 60, 80],
                backgroundColor: "#4CAF50",
                borderRadius: 20,
                barThickness: 30,
                grouped: false
            }
        ]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                display: false
            }
        },
        scales: {
            y: {
                beginAtZero: true,
                max: 100,
                grid: {
                    display: false
                }
            },
            x: {
                grid: {
                    display: false
                }
            }
        }
    }
});