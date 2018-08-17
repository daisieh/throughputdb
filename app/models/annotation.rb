class Annotation 
  include Neo4j::ActiveNode
  property :body, type: String
  property :target, type: String

  has_one :out, :creator, type: :CREATED_BY, model_class: :Person


end
