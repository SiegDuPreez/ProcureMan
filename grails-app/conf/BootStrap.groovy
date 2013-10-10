import org.dupreez.procureman.*

class BootStrap {

	def springSecurityService
	
    def init = { servletContext ->
		
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
		def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

		
		def adminUser = User.findByEmail('sieg@dupreez.org') ?: new User(
			email: 'sieg@dupreez.org',
			password: 'password',
			name: 'Sieg du Preez',
			enabled: true).save(failOnError: true)

		def normalUser = User.findByEmail('a@b.com') ?: new User(
			email: 'a@b.com',
			password: 'aaaaaaaa',
			name: 'At van der Aa',
			enabled: true).save(failOnError: true)

		if (!adminUser.authorities.contains(adminRole)) {
			UserRole.create adminUser, adminRole
		}
		if (!normalUser.authorities.contains(userRole)) {
			UserRole.create normalUser, userRole 
		}
		
		def merchant = Merchant.findByMerchantCode('MERCHANT01') ?: new Merchant(
			merchantCode: 'MERCHANT01', 
			name: 'Test Merchant One'
		).save(failOnError: true)
		
		def subscription = new Subscription(
			user: normalUser,
			merchant: merchant,
			maxProducts: 1000,
			startDate: new Date()
		).save(failOnError: true)
		

    }
    def destroy = {
    }
}
