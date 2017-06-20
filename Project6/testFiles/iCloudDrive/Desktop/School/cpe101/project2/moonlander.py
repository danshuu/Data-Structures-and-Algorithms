#Project 2
#Name: Daniel Shu
#This is the Lunar Module project. In this project I will create a function that will return the result of certain scenarios that are inputted by the user. The program is a game in which the Lunar Module has to land on the ground (altitude of zero) after above ground at a given altitude. With each second that passes by, fuel will be diminishing at an amount based on user's input. When altitude reaches zero, the game is decided on the ending velocity at which the LM reaches the ground.

#main function
def main():
	showWelcome() 

	print("")

	altitude = getAltitude()

	fuelAmount = getFuel()
	
	print("\nLM state at retrorocket cutoff")
	
	elapsedTime = 0
	fuelRate = 0
	velocity = 0
	displayLMState(elapsedTime, altitude, velocity, fuelAmount, fuelRate)

	#asks for fuel rate
	while altitude > 0:
		if fuelAmount > 0:
			elapsedTime = elapsedTime + 1
			#currentFuel = fuelAmount - fuelRate
			fuelRate = getFuelRate(fuelAmount)
			acceleration = updateAcceleration(1.62, fuelRate)
			altitude = updateAltitude(altitude, velocity, acceleration)
			velocity = updateVelocity(velocity, acceleration)
			fuelAmount = updateFuel(fuelAmount, fuelRate)
			
			if fuelAmount > 0:
				displayLMState(elapsedTime, altitude, velocity, fuelAmount, fuelRate)
			else:
				fuelAmount = 0
				print("OUT OF FUEL - Elapsed Time: ", elapsedTime, "Altitude:   ", round(altitude,2), "Velocity:   ", round(velocity,2))
		elif fuelAmount <= 0:
			elapsedTime = elapsedTime + 1
			fuelRate = 0
			acceleration = updateAcceleration(1.62, fuelRate)
			altitude = updateAltitude(altitude, velocity, acceleration)
			velocity = updateVelocity(velocity, acceleration)
			fuelAmount = 0
			print("OUT OF FUEL - Elapsed Time: ", elapsedTime, "Altitude:   ", round(altitude,2), "Velocity:   ", round(velocity,2))
			if altitude <= 0:
				break
			
	print("")
	print("LM state at landing/impact")
	displayLMState(elapsedTime, altitude, velocity, fuelAmount, fuelRate)
	displayLMLandingstatus(velocity)

#PART 1
#FUNCTIONS THAT DO I/O:

#welcome message
def showWelcome():
	print("Welcome aboard the Lunar Module Flight Simulator\n\n   To begin you must specify the LM's initial altitude\n   and fuel level.  To simulate the actual LM use\n   values of 1300 meters and 500 liters, respectively.\n\n   Good luck and may the force be with you!")

def getFuel():
	fuelAmount = eval(input("Enter the initial amount of fuel on board the LM (in liters): "))
	#error message // must be > 0
	if fuelAmount <= 0:
		print("ERROR: Amount of fuel must be positive, please try again")
		getFuel()
	return fuelAmount

def getAltitude():
	altitude = eval(input("Enter the initial altitude of the LM (in meters): "))
	#error message // must be between 1 - 9999
	if altitude < 1 or altitude > 9999:
		print("ERROR: Altitude must be between 1 and 9999, inclusive, please try again")
		getAltitude()
	return altitude

def displayLMState(elapsedTime, altitude, velocity, fuelAmount, fuelRate):

	print("Elapsed Time: ", elapsedTime, "s")
	print("	Fuel: ", int(fuelAmount), "l")
	print("	Rate: ", int(fuelRate), "l/s")
	print("   Altitude: ", "%0.2f"%altitude, "m")
	print("   Velocity: ", "%0.2f"%velocity, "m/s")
	print("")

def getFuelRate(currentFuel):
	fuelRate = eval(input("Enter fuel rate (0-9, 0=freefall, 5=constant velocity, 9=max thrust): "))
	#error message
	if fuelRate < 0 or fuelRate > 9:
		print("ERROR: Fuel rate must be between 0 and 9, inclusive\n")
		fuelRate = getFuelRate(currentFuel)

	if currentFuel < fuelRate:
		return currentFuel
	return int(fuelRate)
	#return lesser of the user entered value or amount of fuel remaining
	#if fuelRate < fuel1:
		#print(fuelRate)
	#elif fuelRate > fuel1:
		#print(fuel)

def displayLMLandingstatus(velocity):
	if velocity < 0 and velocity > -1:
		print("Status at landing - The eagle has landed!")
	elif velocity < -1 and velocity > -10:
		print("Status at landing - Enjoy your oxygen while it lasts!")
	elif velocity < -10:
		print("Status at landing - Ouch - that hurt!")

#FUNCTIONS THAT CALCULATE:

#use a value of 1.62 for gravitational constant when calling this function in part 2
def updateAcceleration(gravity, fuelRate):
	acceleration = gravity * ((fuelRate/5) - 1)
	return acceleration

#parameters are current values
def updateAltitude(altitude, velocity, acceleration):
	altitude1 = altitude + velocity + (acceleration/2)
	if altitude1 > 0:
		return altitude1
	else:
		return 0
	#altitude cannot be negative

#parameters are current values
def updateVelocity(velocity, acceleration):
	velocity1 = velocity + acceleration
	return velocity1

#parameters are current values
def updateFuel(fuel,fuelRate):
	fuel1 = fuel - fuelRate 
	return fuel1


if __name__ == '__main__':
	main()
