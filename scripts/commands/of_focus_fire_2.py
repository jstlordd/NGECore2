import sys

def setup(core, actor, buff):
	return
	
def run(core, actor, target, commandString):
	core.buffService.addBuffToCreature(actor, 'of_focus_fire_2')
	group = core.objectService.getObject(actor.getGroupId())
	if group is not None:
		for creature in group.getMemberList():
			core.buffService.addBuffToCreature(creature, 'of_focus_fire_2')
		return
	return
	