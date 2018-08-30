class Person < Widget
  include Neo4j::ActiveNode
  property :orcid, type: String

  has_many :out, :widgets, type: :CREATES

end
