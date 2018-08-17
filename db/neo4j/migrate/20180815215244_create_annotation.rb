class CreateAnnotation < Neo4j::Migrations::Base
  def up
    add_constraint :Widget, :uuid
  end

  def down
    drop_constraint :Widget, :uuid
  end
end
