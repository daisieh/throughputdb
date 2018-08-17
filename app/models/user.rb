class User 
  include Neo4j::ActiveNode
  property :name, type: String
  property :email, type: String
  property :creator, type: Widget

  has_one :out, :owner, type: :IS_SAME_AS, model_class: :Person

end
