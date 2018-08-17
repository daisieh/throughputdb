class ForceCreatePersonTargetConstraint < Neo4j::Migrations::Base
  def up
    add_constraint :Person, :target, force: true
  end

  def down
    drop_constraint :Person, :target
  end
end
