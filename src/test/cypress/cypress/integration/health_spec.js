describe('Health Test', () => {
	it('Test if website is alive', () => {
		cy.request({
			url: '/',
			method: 'GET'
		}).should((response) => {
			expect(response.status).to.eq(200)
		})
	})
	it('Test if website is healthy', () => {
		cy.request({
			url: '/actuator/health',
			method: 'GET'
		}).its('body').then((body) => {
			expect(body).property('status').contains('UP')
		})
	})
})