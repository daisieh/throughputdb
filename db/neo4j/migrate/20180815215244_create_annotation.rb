class CreateAnnotation < Neo4j::Migrations::Base
  def up
    add_constraint :Annotation, :uuid
  end

  def down
    drop_constraint :Annotation, :uuid
  end
end
