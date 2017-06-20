#Project 1
#Name: Daniel Shu
#The purpose of this project is to calculate the velocity at which the skater will move backwards by taking into account the object and weight inputs.
import math


def main():
	pounds = eval(input("How much do you weigh (pounds)? "))
	massSkater = poundsToKG(pounds)

	distance = eval(input("How far away is the spider (meteres)? "))
	velObject = getVelocityObject(distance)
	
	obj = input("Will you throw a rotten (t)omato, banana cream (p)ie, (l)ight saber, or lawn (g)nome?: ")
	massObject = getMassObject(obj)

	if massObject <= 0.1:
		print("The spider is crawling away!")
	elif massObject > 0.1 and massObject <= 1.0:
		print ("I think you got it!.")
	elif massObject > 1.0:
		if distance < 20:
			print("Nice.")
		else:
			print("You should clean the spider guts off the wall.")
	
	velSkater = getVelocitySkater(massSkater, massObject, velObject)
	print("The velocity of the skater is:", round(velSkater,3), "m/s")


def poundsToKG(pounds):
	massSkater = pounds * 0.453592
	return massSkater #KG

#The weight of the object will be in kilograms
def getMassObject(obj):
	if obj == 't':
		massObject = 0.1
		return massObject
	elif obj == 'p':
		massObject = 1.0
		return massObject
	elif obj == 'r':
		massObject = 3.0
		return massObject
	elif obj == 'g':
		massObject = 5.3
		return massObject
	elif obj == 'l':
		massObject = 9.07
		return massObject
	else:
		massObject = 0.0
		return massObject

#the distance between the skater and the spider will determine that velocity at which the object is thrown towards the spider.
def getVelocityObject(distance):
	gravity = 9.8
	velObject = math.sqrt((gravity * distance)/2)
	return velObject 

#this is the backward velocity of the skater after he throws the object
def getVelocitySkater(massSkater, massObject, velObject):
	velocity_skater = (massObject * velObject)/massSkater
	return velocity_skater

if __name__ == '__main__':
    main()
