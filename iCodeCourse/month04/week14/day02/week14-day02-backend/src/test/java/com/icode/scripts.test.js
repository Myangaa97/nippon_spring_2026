const scripts = divide();
test('divide 6 / 3 to equals 2', () => {
	expect(scripts.add(6, 3)).toBe(3)
})

function divide(a, b) {
	return a / b;
}