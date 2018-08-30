class CreatorToOrcid < Neo4j::Migrations::Base
  def up
    rename_property :User, :creator, :orcid
  end

  def down
    raise Neo4j::IrreversibleMigration
  end
end
