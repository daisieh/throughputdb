class Person < Widget
  include Neo4j::ActiveNode

  has_many :out, :widgets, type: :CREATES

end
