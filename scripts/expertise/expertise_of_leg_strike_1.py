import sys

def addExpertisePoint(core, actor):

	player = actor.getSlottedObject('ghost')

	if not player:
		return

	if not player.getProfession() == 'officer_1a':
		return

	actor.addSkill('expertise_of_leg_strike_1')


	addAbilities(core, actor, player)

	return

def removeExpertisePoint(core, actor):

	player = actor.getSlottedObject('ghost')

	if not player:
		return

	if not player.getProfession() == 'officer_1a':
		return

	actor.removeSkill('expertise_of_leg_strike_1')


	removeAbilities(core, actor, player)

	return

# this checks what abilities the player gets by level, need to also call this on level-up
def addAbilities(core, actor, player):

	actor.addAbility('of_leg_strike_1')

	return

def removeAbilities(core, actor, player):

	actor.removeAbility('of_leg_strike_1')

	return