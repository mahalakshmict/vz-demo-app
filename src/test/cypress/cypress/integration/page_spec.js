describe('Webpage Test', () => {
  it('Find and check Artifactory', () => {
    cy.visit('/')
    cy.contains('Artifactory').click()
  })
  it('Find and check PG Admin', () => {
    cy.visit('/')
    cy.contains('PG Admin').click()
  })
  it('Find and check Adminer', () => {
    cy.visit('/')
    cy.contains('Adminer').click()
  })
})
